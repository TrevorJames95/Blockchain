package blockchain;

import java.security.MessageDigest;

public class Block {

    private String hash;
    private String previousHash;
    private long timeStamp;

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }


    Block(String hash, String previousHash, long timeStamp){
        this.hash = hash;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
    }
}
