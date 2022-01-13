
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall  implements Structure, CompositeBlock{

    private List<Block> blocks;
  //  Block block = compositeBlock;

    public List<Block> getBlocks() {
        return blocks;
    }
    String color ;
    String material;

    @Override
    public Optional<Block> findBlockByColor(String color)  {

        Optional<Block> block = blocks.stream().filter(element -> element.getColor().equals(color)).findFirst();

        block.orElseThrow(()->new RuntimeException("Color doesn't exist"));
        return block;


    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
       return blocks.stream().filter(element->element.getMaterial().equals(material)).collect(Collectors.toList());






    }

    @Override
    public int count() {
      return   blocks.size();
    }


    @Override
    public String getColor() {
        return compositeBlock.getColor();
    }

    @Override
    public String getMaterial() {
        return compositeBlock.getMaterial();
    }
    CompositeBlock compositeBlock = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
           return blocks;
        }

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public String getMaterial() {
            return material;
        }
    };


}
