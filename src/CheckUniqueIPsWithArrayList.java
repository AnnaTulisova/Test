import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheckUniqueIPsWithArrayList {

    public int getUniqueIPsCountFromFile(String fileName){
        int countOfUnique = 0;
       ArrayList<IPAddress> uniqueIPsArray = new ArrayList <IPAddress>();
        try {
            Scanner fileScan = new Scanner(new File(fileName));
            while(fileScan.hasNextLine())
                checkFile(fileScan.next(), uniqueIPsArray);

            fileScan.close();
            countOfUnique = uniqueIPsArray.isEmpty() ? 0 : countUnique(uniqueIPsArray);
        }
        catch (Exception ex) {
            System.out.println("Exception!!! \n" + ex);
        }
        return countOfUnique;
    }

    public void checkFile(String fileRow, ArrayList<IPAddress> uniqueIPsArray){
        Collections.sort(uniqueIPsArray);
        IPAddress oldIPAddressInfo = binarySearchForTheAddress(fileRow, uniqueIPsArray);
        if(oldIPAddressInfo != null)
            oldIPAddressInfo.setCountOfAddress(oldIPAddressInfo.countOfAddress + 1);
        else
            uniqueIPsArray.add(new IPAddress(fileRow,1));
    }

    public int countUnique(ArrayList<IPAddress> uniqueIPsArray){
        int c = uniqueIPsArray.isEmpty()
                ? 0
                : (int) uniqueIPsArray.stream().filter(x->x.getCountOfAddress() == 1).count();
        return c;
    }

    public IPAddress binarySearchForTheAddress(String addressToFind, ArrayList<IPAddress> uniqueIPsArray){
        if(uniqueIPsArray.isEmpty())
            return null;
        int firstId = 0;
        int lastId = uniqueIPsArray.size() - 1;
        IPAddress IPAddressToFind = new IPAddress(addressToFind, 1);
        while (firstId <= lastId){
            int middleId = (firstId + lastId) / 2;
            if(uniqueIPsArray.get(middleId).compareTo(IPAddressToFind) == 0)
                return uniqueIPsArray.get(middleId);
            else if(uniqueIPsArray.get(middleId).compareTo(IPAddressToFind) < 0)
                firstId = middleId + 1;
            else if(uniqueIPsArray.get(middleId).compareTo(IPAddressToFind) > 0)
                lastId = middleId -1;
        }
        return  null;
    }
}
