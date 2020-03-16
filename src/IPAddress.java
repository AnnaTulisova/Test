public class IPAddress implements Comparable<IPAddress>{
    public String ipAddress;
    public Integer countOfAddress;

    public String getIpAddress(){return ipAddress;}

    public void setIpAddress(String address){ ipAddress = address; }

    public Integer getCountOfAddress(){ return countOfAddress; }

    public void setCountOfAddress(Integer count){ countOfAddress = count; }

    public IPAddress (String address, Integer count){
        ipAddress = address;
        countOfAddress = count;
    }

    @Override
    public int compareTo(IPAddress o) {
        return ipAddress.compareTo(o.getIpAddress());
    }
}
