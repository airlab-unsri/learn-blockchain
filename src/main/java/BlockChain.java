import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {

  private List chain;

  public BlockChain() {
    this.chain = new ArrayList();
    this.chain.add(createGenesisBlock());
  }

  private Block createGenesisBlock() {
    return new Block(0, new Date(), "Genesis block", "0");
  }

  public void add(Block newBlock) {
    String previousHashVal = ((Block) this.getLatestBlock()).getCurrentHashVal();

    newBlock.setPreviousHashVal(previousHashVal);
    newBlock.mineBlock(5);

    this.chain.add(newBlock);
  }

  public Object getLatestBlock() {
    return this.chain.get(this.chain.size() - 1);
  }

  public List getChain() {
    return chain;
  }

  public void setChain(List chain) {
    this.chain = chain;
  }

}
