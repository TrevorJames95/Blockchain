package blockchain;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {
    private static List<Block> blockChain = new ArrayList<>();

    public static void generateBlocks(int hmBlocks){
        for (int i = 0; i < hmBlocks; i++) {
            long timeStamp = new Date().getTime();
            //if the index is at 0 for the first block, our previous hash should be 0;
            String previousHash = i==0? "0" : blockChain.get(i-1).getHash() ;
            String hash = calculateHash(previousHash + timeStamp);
            Block block = new Block(hash, previousHash, timeStamp);
            blockChain.add(block);
        }
    }

    public static String calculateHash(String input){
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
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayChain(){
        for (int i = 0; i < blockChain.size(); i++) {
            System.out.println("Block:");
            System.out.println("Id: " + (i+1));
            System.out.println("Timestamp: " + blockChain.get(i).getTimeStamp());
            System.out.println("Hash of the previous block:");
            System.out.println(blockChain.get(i).getPreviousHash());
            System.out.println("Hash of the block:");
            System.out.println(blockChain.get(i).getHash());
            System.out.println();
        }
    }
}
