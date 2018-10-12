package mybatis.mapper;

import java.util.List;

import com.cn.model.SysRole;
import com.cn.model.SysUser;

public interface UserMapper {
    /**
     * 通过id查询用户
     * @param id
     * @return
     */
	SysUser selectById(Long id);
	/*
	 * 
	 *查询所有用户
	 *@return
	 */
	List<SysUser> selectAll();
	/*
	 * 修改mybatis-config配置后测试<settings>
	    <setting name="mapUnderscoreToCamelCase" value="true"/>
	</settings>
	 * 
	 */
	List<SysUser> selectAllTest();
	List<SysRole> selectRolesByUserId(Long id);
	int insert(SysUser sysUser);
	int insert2(SysUser sysUser);
	int insert3(SysUser sysUser);
	/*
	 * @param sysUser
	 * @return
	 * 
	 * 
	 */
	int updateById(SysUser sysUser);
	
	/*
	 * @param SysUser
	 * @return 
	 * 
	 */
	int deleteById(Long id);
}
