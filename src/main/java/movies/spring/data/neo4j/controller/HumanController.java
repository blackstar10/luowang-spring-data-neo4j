package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.repositories.HumanRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Create on 2018/7/30 15:37
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RestController
@RequestMapping("/rest/human")
public class HumanController {

    private final HumanRepository humanRepositiory;

    public HumanController(HumanRepository humanRepositiory) {
        this.humanRepositiory = humanRepositiory;
    }

    @RequestMapping("/get")
    public Collection<Human> GetCoderByName(@RequestParam(value="name") String name){
        return humanRepositiory.findByName(name);
    }

//    @RequestMapping("/get2")
//    public Collection<Human> GetCoderByGender(@RequestParam(value="gender") GenderTypes gender){
//        return humanRepositiory.findByGender(gender);
//    }
//    @RequestMapping("/get3")
//    public Collection<Human> GetCoderByIdNumber(@RequestParam(value="idNumber") String idNumber){
//        return humanRepositiory.getHumanByIdNumber(idNumber);
//    }
}
