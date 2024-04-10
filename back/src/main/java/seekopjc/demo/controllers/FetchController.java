package seekopjc.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/gifs")
public class FetchController {
    
    @GetMapping()
    public Object index(HttpServletRequest request){
        
        String gifName=request.getParameter("gifName");
        String gifLimit=request.getParameter("gifLimit");
        String gifOffset=request.getParameter("gifOffset");
        // String url="https://reqres.in/api/users?page=2";
        String url="https://api.giphy.com/v1/gifs/search?api_key=lI09ZjjSKSyLwg9Mn2tVtlB4K0dKHzyp"+
        "&q="+gifName+"&"+
        "limit="+(gifLimit==null?"25":gifLimit)+"&offset="+(gifOffset==null?"0":gifOffset)+
        "&rating=g&lang=en&bundle=messaging_non_clips";
        WebClient webClient=WebClient.create();

        String response=webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(String.class)
            .block();
            
       
        return response;
    }
}
