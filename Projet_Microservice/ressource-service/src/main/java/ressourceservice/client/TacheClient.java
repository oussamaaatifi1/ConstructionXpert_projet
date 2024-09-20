package ressourceservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tache-service", url = "http://localhost:8082")
public interface TacheClient {

    @GetMapping("/taches/idTache")
    Object getTacheById(@RequestParam("idTache") int idTache);
}