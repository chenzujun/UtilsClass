
import java.io.Serializable;

/** Menu
	MENUID    INT(11)
	MENUNAME    VARCHAR(50)
	PARENTID    INT(11)
	URL    VARCHAR(100)
	ISDISPLAY    TINYINT(4)
	ORDERNO    INT(6)
*/
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private String menuName;
	private Integer parentId;
	private String url;
	private Integer isDisplay;
	private Integer orderNo;

	public void setMenuId(Integer menuId){
		this.menuId=menuId;
	}
	public Integer getMenuId(){
		return menuId;
	}
	public void setMenuName(String menuName){
		this.menuName=menuName;
	}
	public String getMenuName(){
		return menuName;
	}
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	public Integer getParentId(){
		return parentId;
	}
	public void setUrl(String url){
		this.url=url;
	}
	public String getUrl(){
		return url;
	}
	public void setIsDisplay(Integer isDisplay){
		this.isDisplay=isDisplay;
	}
	public Integer getIsDisplay(){
		return isDisplay;
	}
	public void setOrderNo(Integer orderNo){
		this.orderNo=orderNo;
	}
	public Integer getOrderNo(){
		return orderNo;
	}
}

