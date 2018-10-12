import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moli.cms.service.CmsCategoryService;
import com.moli.common.pojo.EasyUITreeNode;

public class ControllerTest {
	@Autowired
    private CmsCategoryService cmsCategoryService;
	@Test
	public void controllerTest() {
    	List<EasyUITreeNode> nodes = cmsCategoryService.getCmsCategoryList(1L);
        System.out.println(nodes.get(0).getId()+""+nodes.get(0).getState()+""+nodes.get(0).getText());
	}
	
}
