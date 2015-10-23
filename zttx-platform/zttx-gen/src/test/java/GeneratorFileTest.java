import com.zttx.web.gen.GeneratorFile;
import junit.framework.TestCase;

/**
 * <p>File：GeneratorFileTest.java </p>
 * <p>Title: 代码生成测试 </p>
 * <p>Description: GeneratorFileTest </p>
 * <p>Copyright: Copyright (c) 2014 08/07/2015 12:12</p>
 * <p>Company: 8637.com</p>
 *
 * @author playguy
 * @version 1.0
 */
public class GeneratorFileTest extends TestCase
{
    protected GeneratorFile generatorFile = new GeneratorFile();
    
    public void testGenerateCRUDByTables() throws Exception
    {
        generatorFile.generateCRUDByTables(new String[]{"DealerShopEnvTemp"});
    }
}