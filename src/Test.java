public class Test {
    public static void main(String[] args) {
        String fileName = "test.txt";
        int countOfUnique =  new CheckUniqueIPsWithArrayList().getUniqueIPsCountFromFile(fileName);
        System.out.println("Unique IPs Count is " + countOfUnique);
    }
}
