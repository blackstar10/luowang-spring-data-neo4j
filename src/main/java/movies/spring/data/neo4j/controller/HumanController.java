package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.repositories.HumanRepository;
import movies.spring.data.neo4j.services.HumanService;
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

    private final HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @RequestMapping("/get")
    public Collection<Human> GetHumanByName(@RequestParam(value="name") String name){
        return humanService.findByName(name);
    }

    @RequestMapping("/getByIdNumber")
    public Collection<Human> GetHumanByIdNumber(@RequestParam(value="id") String idNumber){
        return humanService.findByIdNumber(idNumber);
    }
    @RequestMapping("/save")
    public Human createHumanByProperties(@RequestParam(value="name") String name){
        return humanService.createHuman(name);
    }
    @RequestMapping("/update")
    public Human updateHumanByProperties(@RequestParam(value="name") String name){
        return humanService.createHuman(name);
    }
    @RequestMapping("/delete")
    public Human deleteHumanByProperties(@RequestParam(value="name") String name){
        return humanService.createHuman(name);
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
