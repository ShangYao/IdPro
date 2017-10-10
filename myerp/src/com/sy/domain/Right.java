package com.sy.domain;

import java.util.ArrayList;
import java.util.List;

import com.sy.annotation.SDGAColumn;
import com.sy.annotation.SDGATable;
import com.sy.pub.dao.SqlSupport;
import com.sy.pub.domain.BuildSqlDomain;
@SDGATable(name="rights")
public class Right extends SqlSupport {
	@SDGAColumn(primaryKey=true)
	private String right_code;//权限代号
	@SDGAColumn()
	private String right_name;//权限名称
	@SDGAColumn()
	private String main_menu_name;//菜单序号
	@SDGAColumn()
	private String second_menu_name ;//二级菜单序号
	@SDGAColumn()
	private String action;
	
		@Override
		public BuildSqlDomain getSqlAndValues(String key) {
			// TODO Auto-generated method stub
			BuildSqlDomain  sqldomain=new BuildSqlDomain();
			List<String> paralist = new ArrayList<String>();
			StringBuffer sql = new StringBuffer();

			sqldomain.setSql(sql.toString());
			sqldomain.setObject(paralist.toArray());
			return sqldomain;
		}

		public String getRight_code() {
			return right_code;
		}

		public void setRight_code(String right_code) {
			this.right_code = right_code;
		}

		public String getRight_name() {
			return right_name;
		}

		public void setRight_name(String right_name) {
			this.right_name = right_name;
		}

		public String getMain_menu_name() {
			return main_menu_name;
		}

		public void setMain_menu_name(String main_menu_name) {
			this.main_menu_name = main_menu_name;
		}

		public String getSecond_menu_name() {
			return second_menu_name;
		}

		public void setSecond_menu_name(String second_menu_name) {
			this.second_menu_name = second_menu_name;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

	}

