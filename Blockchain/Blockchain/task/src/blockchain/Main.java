package blockchain;

public class Main {
    public static void main(String[] args) {
        BlockChain bc = new BlockChain();
        bc.generateBlocks(5);
        bc.displayChain();
    }
}
