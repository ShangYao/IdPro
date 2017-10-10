package com.sy.service.imp;

import java.util.List;

import com.sy.domain.Id;
import com.sy.form.IdForm;
import com.sy.pub.component.PageData;
import com.sy.pub.dao.DefaultDynamicSqlDao;
import com.sy.pub.domain.Model;
import com.sy.pub.domain.ModelFactory;
import com.sy.service.ICodeService;
import com.sy.service.IService;

public class IdManageServiceImpl implements IService {
	private DefaultDynamicSqlDao dynamicsqldao;

	private ICodeService codeService;

	public DefaultDynamicSqlDao getDynamicsqldao() {
		return dynamicsqldao;
	}

	public void setDynamicsqldao(DefaultDynamicSqlDao dynamicsqldao) {
		this.dynamicsqldao = dynamicsqldao;
	}

	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}

	@Override
	public Model processBusiness(Object command) {
		// TODO Auto-generated method stub
		IdForm idForm = (IdForm) command;
		String type = idForm.getYwtype();
		if ("load".equals(type)) {
			return ModelFactory.createModel(idForm, "idManage");
		} else if ("id_cx".equals(type)) {
			return idcx(idForm);
		} else if ("id_sc".equals(type)) {
			return idsc(idForm);
		} else if ("id_xq".equals(type)) {
			return idxq(idForm);
		}
		return null;

	}

	private Model idxq(IdForm idForm) {
		// TODO Auto-generated method stub
		Id id = idForm.getId();
		id.setId_number(idForm.getId_temp());
		Id id1 = (Id) this.dynamicsqldao.selectByPk(id);
		idForm.setId(id1);
		return ModelFactory.createModel(idForm, "id_details");
	}

	private Model idsc(IdForm idForm) {
		// TODO Auto-generated method stub
		Id id = new Id();
		id.setId_number(idForm.getId_temp());
		long n = this.dynamicsqldao.deleteByPk(id);
		if (n != 0) {
			idForm.setYwstate("删除成功！");
			idForm.setId(null);
			id.setId_number(null);
			long n1 = this.dynamicsqldao.queryForLongBynamicSql(id);
			if (n1 != 0) {
				PageData pagedata = new PageData(n1, id.getItemCountPerPage(),
						id.getPageNumber());
				id.setPagadata(pagedata);
				List ls = this.dynamicsqldao.findbyWhere(id, Id.class);
				idForm.setCxlist(ls);
			} else {
				idForm.setYwstate("没有符合条件的数据");
			}
		}
		return ModelFactory.createModel(idForm, "idManage");

	}

	private Model idcx(IdForm idForm) {
		Id id = idForm.getId();
		long n = this.dynamicsqldao.queryForLongBynamicSql(id);
		if (n != 0) {
			PageData pagedata = new PageData(n, id.getItemCountPerPage(),
					id.getPageNumber());
			id.setPagadata(pagedata);
			List<Id> ls = this.dynamicsqldao.findbyWhere(id, Id.class);
			idForm.setCxlist(ls);
		} else {
			idForm.setYwstate("查无数据！");
		}
		return ModelFactory.createModel(idForm, "idManage");

	}
}
