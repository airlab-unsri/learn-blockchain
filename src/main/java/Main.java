import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    // init code
    BlockChain blockChain = new BlockChain();

    // transaksi pertama wenty - beli di warung A
    blockChain.add(new Block(1, new Date(), "first block"));

    // transaksi kedua faisal - beli diwarung B
    blockChain.add(new Block(2, new Date(), "second block"));

    // transaksi ketiga
    blockChain.add(new Block(3, new Date(), "delete block 1"));

    List allCoin = blockChain.getChain();
    System.out.println(allCoin.size());

    String previousHashValue = ((Block) allCoin.get(1)).getCurrentHashVal();
    String currentHashValue = ((Block) allCoin.get(2)).getPreviousHashVal();


    ((Block) allCoin.get(1)).setData("first block modified ++ ");
    Block alterBlock = (Block) allCoin.get(1);
    String hashValue = alterBlock.calculateHash();

    System.out.println(currentHashValue);
    System.out.println(hashValue);
  }
}
