package ressourceservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Tache", url = "http://localhost:8070")
public interface TacheClient {

    @GetMapping("/taches/idTache")
    Object getTacheById(@RequestParam("idTache") int idTache);
}