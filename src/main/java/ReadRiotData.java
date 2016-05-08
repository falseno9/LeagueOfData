import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;

import java.util.Map;

/**
 * Created by Kunal on 5/8/2016.
 */
public class ReadRiotData {

    public static void main(String[] args) throws RiotApiException {

        RiotApi api = new RiotApi("b45a7774-67ad-4c25-ad84-33f5462f098b");

        Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, "falseno9, orianna");
        Summoner summoner = summoners.get("falseno9");
        long id = summoner.getId();
        System.out.println(id);
    }
}

