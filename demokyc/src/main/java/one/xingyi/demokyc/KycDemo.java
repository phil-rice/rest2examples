package one.xingyi.demokyc;
import one.xingyi.core.http.JavaHttpClient;
import one.xingyi.core.httpClient.HttpServiceCompletableFuture;
import one.xingyi.json.Json;
public class KycDemo {
    public static void main(String[] args) {
        HttpServiceCompletableFuture service = HttpServiceCompletableFuture.lensService("http://localhost:9000", new Json(), JavaHttpClient.client);
        while (true) {
            try {
                Thread.sleep(2000);
//                IDView.edit(service, "id1", old -> old.withid("newId"));
                System.out.println("..");
//
//                        PersonLine12View.getOptional(service, "id1", view -> view.xingYi().render("json", view) + "\n       ==>  " + view.line1()).get());
//                IDView.edit(service, "id1", id -> id.withid("someNewId")).get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
