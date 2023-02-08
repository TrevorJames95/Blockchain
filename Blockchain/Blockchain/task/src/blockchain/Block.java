package blockchain;

import java.security.MessageDigest;

public class Block {

    private String hash;
    private String previousHash;
    private long timeStamp;
    private long generationTime;
    private int magicNumber;

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public long getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(long generationTime) {
        this.generationTime = generationTime;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }


    Block(String hash, String previousHash, int magicNumber, long timeStamp, long generationTime){
        this.hash = hash;
        this.previousHash = previousHash;
        this.magicNumber = magicNumber;
        this.timeStamp = timeStamp;
        this.generationTime = generationTime;
    }
}
