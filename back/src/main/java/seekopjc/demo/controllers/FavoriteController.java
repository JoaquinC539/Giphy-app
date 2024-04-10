package seekopjc.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import jakarta.servlet.http.HttpServletRequest;
import seekopjc.demo.models.Favorito;
import seekopjc.demo.services.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    private FavoriteService favoriteService;
    public FavoriteController(FavoriteService fService){
        this.favoriteService=fService;
    }
    @GetMapping()
    public ArrayList<Object> index(HttpServletRequest request){
        try {
            ArrayList<Object> response=favoriteService.index(request);
            if(response==null){
                HashMap<String,String> map=new HashMap<>();
                map.put("error", "error fetcginh favorites");
                ArrayList<Object> err=new ArrayList<Object>();
                err.add(map);
                return err;
            }
            return response;
        } catch (Exception e) {
            ArrayList<Object> errorResp=new ArrayList<Object>();
            HashMap<String,Object> desc=new HashMap<String,Object>();
            desc.put("error", e);
            errorResp.add(desc);
            System.out.println(e);
            return errorResp;
        }
    }
    @PostMapping()
    public Favorito post(@RequestBody Favorito favorito) throws SQLException{
        try {
            Favorito fav=favoriteService.save(favorito);
            if(fav==null){
                return null;
            }
            return fav;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }  
    }

    @DeleteMapping(value = "/{id}")
    public HashMap<String,Object> delete(@PathVariable("id") Integer id, HttpServletRequest request){
        Integer delid=favoriteService.delete(id);
        if(delid==null){
            HashMap<String,Object> response=new HashMap<>();
            response.put("error", true);
            response.put("message", "favorito no borrado"); 
            return response;
        }
        HashMap<String,Object> response=new HashMap<>();
        response.put("error", false);
        response.put("message", "favorito borrado");
        
        return response;
    }


}
