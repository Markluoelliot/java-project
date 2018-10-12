import org.junit.Test;

import com.moli.common.pojo.MoliResult;

public class MoliResultTest {
    //@Test
	public void moliResultTest() {
		MoliResult ok = MoliResult.ok();
	    System.out.println(ok.getData()+""+ok.getStatus()+""+ok.getMsg());
    }
}
