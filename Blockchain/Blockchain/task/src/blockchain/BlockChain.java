package blockchain;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockChain {
    private List<Block> blockChain;
    private int numOfLeadingZeros;

    private String strOfZeros;

    public BlockChain(int numOfLeadingZeros) {
        blockChain = new ArrayList<>();
        //default number of blocks to generate is passed into generateBlocks.
        this.numOfLeadingZeros = numOfLeadingZeros;
        generateZeroString();
        generateBlocks(5);
    }

    private void generateZeroString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfLeadingZeros; i++) {
            sb.append('0');
        }
        strOfZeros = sb.toString();
    }

    public void generateBlocks(int numberOfBlocks){
        for (int i = 0; i < numberOfBlocks; i++) {
            long timeStamp = System.currentTimeMillis();
            int magicNumber = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
            //if the index is at 0 for the first block, our previous hash should be 0;
            String previousHash = i==0? "0" : blockChain.get(i-1).getHash() ;
            String hash = calculateHash(previousHash + timeStamp);
            long generationTime = System.currentTimeMillis() - timeStamp;
            Block block = new Block(hash, previousHash, magicNumber, timeStamp, generationTime);
            blockChain.add(block);
        }
    }

    public String calculateHash(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            hexString.replace(0, numOfLeadingZeros, strOfZeros);
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void displayChain(){
        for (int i = 0; i < blockChain.size(); i++) {
            System.out.println("Block:");
            System.out.printf("Id: %d\n", (i+1));
            System.out.printf("Timestamp: %d\n", blockChain.get(i).getTimeStamp());
            System.out.printf("Magic number: %d\n", blockChain.get(i).getMagicNumber());
            System.out.printf("Hash of the previous block: \n%s\n", blockChain.get(i).getPreviousHash());
            System.out.printf("Hash of the block: \n%s\n", blockChain.get(i).getHash());
            System.out.printf("Block was generating for %d seconds\n\n", blockChain.get(i).getGenerationTime());
        }
    }
}
