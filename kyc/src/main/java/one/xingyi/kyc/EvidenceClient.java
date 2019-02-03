package one.xingyi.kyc;
import one.xingyi.core.http.JavaHttpClient;
import one.xingyi.core.httpClient.HttpServiceCompletableFuture;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.evidence.details.client.view.EvidenceDetailsPostView;
import one.xingyi.kyc.evidence.main.client.view.EvidencePost;
import one.xingyi.kyc.evidence.main.client.view.EvidenceView;

import java.util.concurrent.ExecutionException;
public class EvidenceClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HttpServiceCompletableFuture service = HttpServiceCompletableFuture.defaultService("http://localhost:9000", JavaHttpClient.client);
//        String customerSalt = SaltView.create(service, "myCustomerId").get().salt();
        EvidencePost prototype = EvidencePost.get(service, "prototype", x -> x).get();
        EvidenceDetailsPostView prototypeDetails = EvidenceDetailsPostView.get(service, "prototype", x -> x).get();

        EvidencePost post = prototype.withdate("thisDate").withsalt("someSalt").withfacts(
                prototype.facts().
                        append(prototypeDetails.withname("name1").withvalue("value1").withmime("text/plain")).
                        append(prototypeDetails.withname("name2").withvalue("value2").withdigest("false")).
                        append(prototypeDetails.withname("name3").withvalue("value3"))
        );

        System.out.println("The post will be" + post.xingYi().render("json", post));

        IdAndValue<EvidencePost> initialCreate = EvidencePost.create(service, post).get();
        System.out.println(initialCreate.id + " for " + initialCreate.t.xingYi().render("json", initialCreate.t));
        System.out.println("Id was:        "+ initialCreate.id);

        IdAndValue<EvidencePost> secondCreate = EvidencePost.create(service, post).get();
        System.out.println("second id was: "+ secondCreate.id);

        System.out.println("From store: "+ EvidenceView.get(service, secondCreate.id, res->res.xingYi().render("json", res)).get());


    }
}