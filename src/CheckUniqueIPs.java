import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class CheckUniqueIPs {

    public int getUniqueIPsCountFromFile(String fileName){
        int countOfUnique = 0;
        Map<String, Integer> uniqueIPsMap = new HashMap<String, Integer>();
        try {
            Scanner fileScan = new Scanner(new File(fileName));
            while(fileScan.hasNextLine())
                checkFile(fileScan.next(), uniqueIPsMap);
            fileScan.close();
            countOfUnique = uniqueIPsMap.isEmpty() ? 0 : countUnique(uniqueIPsMap);
        }
        catch (Exception ex) {
            System.out.println("Exception!!! \n" + ex);
        }
        return countOfUnique;
    }

    public void checkFile(String fileRow, Map<String, Integer> uniqueMap){
        if(uniqueMap.containsKey(fileRow)){
            int oldCount = uniqueMap.get(fileRow);
            uniqueMap.put(fileRow, oldCount + 1);
        }else
            uniqueMap.put(fileRow, 1);
    }

    public int countUnique(Map<String, Integer> uniqueMap){
       int countOfUniqueIPs =  uniqueMap.isEmpty()
                ? 0
                : (int) uniqueMap.values().stream().filter(x -> x == 1).count();
        return countOfUniqueIPs;
    }
}
