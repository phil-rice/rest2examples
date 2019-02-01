package one.xingyi.kyc;
import one.xingyi.core.http.JavaHttpClient;
import one.xingyi.core.httpClient.HttpServiceCompletableFuture;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.fact.client.view.FactDetailsView;
import one.xingyi.kyc.fact.client.view.FactView;
import one.xingyi.kyc.fact.server.domain.FactDetails;
import one.xingyi.kyc.salt.client.view.SaltView;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class KycClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HttpServiceCompletableFuture service = HttpServiceCompletableFuture.defaultService("http://localhost:9000", JavaHttpClient.client);
        String customerSalt = SaltView.create(service, "myCustomerId").get().salt();
        FactView prototypeFactView = FactView.get(service, "prototype", x -> x).get();
        FactDetailsView prototypeFactDetailsView = FactDetailsView.get(service, "prototype", x -> x).get();

        System.out.println("Salt:                      " + customerSalt);
        System.out.println("prototypeFactView:         " + prototypeFactView.xingYi().render("json", prototypeFactView));
        System.out.println("prototypeFactDetailsView:  " + prototypeFactDetailsView.xingYi().render("json", prototypeFactDetailsView));
        System.out.println();

        FactView factView = prototypeFactView.withdate("thisDate").withsalt(customerSalt).withfacts(
                prototypeFactView.facts().
                        append(prototypeFactDetailsView.withname("name1").withvalue("value1")).
                        append(prototypeFactDetailsView.withname("name2").withvalue("value2")).
                        append(prototypeFactDetailsView.withname("name3").withvalue("value3"))
        );

        System.out.println("The prototype transformed is" + factView.xingYi().render("json", factView));

        IdAndValue<FactView> initialCreate = FactView.create(service, factView).get();
        System.out.println(initialCreate.id + " for " + initialCreate.t.xingYi().render("json", initialCreate.t));
    }
}