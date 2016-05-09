import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Champion.ChampionList;
import net.rithms.riot.dto.ChampionMastery.ChampionMastery;
import net.rithms.riot.dto.Summoner.Summoner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kunal on 5/8/2016.
 */
public class ReadRiotData {
    private static final RiotApi api = new RiotApi("b45a7774-67ad-4c25-ad84-33f5462f098b");
    private static final Map<Long, String> championLookup = new HashMap<>();

    private static void createChampionLookup() throws RiotApiException {
        ChampionList championList = new ChampionList();
        championList.forEach((k, v) -> System.out.println(k + "," + v));


    }

    public static void main(String[] args) throws RiotApiException {
        ReadRiotData data = new ReadRiotData();
        createChampionLookup();
        //data.getChampionMasteries("falseno9");
    }

    public void getChampionMasteries(String summonerName) throws RiotApiException {
        List<ChampionMastery> championMasteries = api.getChampionMasteries(PlatformId.NA, getSummonerId(summonerName));
        championMasteries.forEach(championMastery -> System.out.println(championMastery.getChampionId()));
    }

    private long getSummonerId(String summonerName) throws RiotApiException {
        Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, summonerName);
        Summoner summoner = summoners.get(summonerName);
        return summoner.getId();
    }
}

