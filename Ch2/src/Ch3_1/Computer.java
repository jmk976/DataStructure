package Ch3_1;

public class Computer {

    private String manufacturer;
    private String processor;
    private int ramSize;
    private int diskSize;
    private double processorSpeed;

   // 생성자
    public Computer(String man, String proc, int ram, int disk, double procSpeed){

        manufacturer = man;
        processor = proc;
        ramSize = ram;
        diskSize = disk;
        processorSpeed = procSpeed;

    }

    public double computerPower(){      //계산능력
        return ramSize * processorSpeed;
    }

    public double getReamSize(){
        return ramSize;
    }
    public double getProcessorSpeed(){
        return processorSpeed;
    }
    public double getDiskSize(){
        return diskSize;
    }

    public String toString(){ // 데이터 출력용
        String result = "Manufacturer:: " +manufacturer +
                        "\nCPU:: " +processor +
                        "\nRAM:: " +ramSize +" megabytes"+
                        "\nDisk:: " +diskSize +" gigabytes"+
                        "\nProcessor speed:: " +processorSpeed + " gigaherts";
        return result;
    }
}
