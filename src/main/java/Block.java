import java.nio.charset.StandardCharsets;
import com.google.common.hash.Hashing;

import java.util.Date;

public class Block {

  private int index;
  private Date timestamp;
  private String data;
  private String previousHashVal;
  private String currentHashVal;
  private int nonce;

  public Block(int index, Date timestamp, String data, String previousHash) {
    this.index = index;
    this.timestamp = timestamp;
    this.data = data;
    this.previousHashVal = previousHash;
    this.currentHashVal = this.calculateHash();
    this.nonce = 0;
  }

  public Block(int index, Date timestamp, String data) {
    this.index = index;
    this.timestamp = timestamp;
    this.data = data;
    this.previousHashVal = null;
    this.currentHashVal = this.calculateHash();
    this.nonce = 0;
  }

  public String calculateHash() {
    String dataToHash = Integer.toString(this.index) + this.previousHashVal + this.data + this.nonce;

    return Hashing.sha256()
        .hashString(dataToHash, StandardCharsets.UTF_8)
        .toString();
  }

  public void mineBlock(int difficulty) {
    String strDifficulty = "";
    for (int i = 0; i < difficulty; i++) {
      strDifficulty += "0";
    }

    String substrHashValue = this.currentHashVal.substring(0, difficulty);
    boolean flag = substrHashValue.equals(strDifficulty);

    while (flag == false) {
      this.nonce++;
      this.currentHashVal = this.calculateHash();

      substrHashValue = this.currentHashVal.substring(0, difficulty);
      flag = substrHashValue.equals(strDifficulty);
    }
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getPreviousHashVal() {
    return previousHashVal;
  }

  public void setPreviousHashVal(String previousHashVal) {
    this.previousHashVal = previousHashVal;
  }

  public String getCurrentHashVal() {
    return currentHashVal;
  }

  public void setCurrentHashVal(String currentHashVal) {
    this.currentHashVal = currentHashVal;
  }

  public int getNonce() {
    return nonce;
  }

  public void setNonce(int nonce) {
    this.nonce = nonce;
  }
}
