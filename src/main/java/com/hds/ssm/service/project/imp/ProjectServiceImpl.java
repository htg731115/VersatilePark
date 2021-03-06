package com.hds.ssm.service.project.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.ProjectDao;
import com.hds.ssm.model.Project;
import com.hds.ssm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value="ProjectService")
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectDao projectDao;

    @Override
    public PageInfo<Project> selectProject(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Project> userInfoList = projectDao.selectProject();
        PageInfo<Project> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }

    @Override
    public List<Project> getEmptyProject() {
        return projectDao.getEmptyProject();
    }

    @Override
    public void alterPorject(int admin_id, String project) {
        projectDao.clearProject(admin_id);
        projectDao.alterProject(admin_id,project);
    }

    @Override
    public void addProject(String name, String address, Date opentime, int area, int total_num, int manage_num, int state, int admin_id) {
        projectDao.addProject(name,address,opentime,area,total_num,manage_num,state,admin_id);
    }

    @Override
    public Project findProject(String name) {
        return projectDao.findProject(name);
    }

    @Override
    public List<Project> getAllProject() {
        return projectDao.getAllProject();
    }

    @Override
    public Project findProjectById(int id) {
        return projectDao.findProjectById(id);
    }

    @Override
    public Project findProjectByAdminId(int adminId) {
         return projectDao.findProjectByAdminId(adminId);

    }

    @Override
    public void editProject(Integer projectId, String name, String address, Integer area,Integer manageNum) {
        projectDao.editProject(projectId,name,address,area,manageNum);
    }

    @Override
    public void alterProject(Integer projectId, String name, String address, Integer area, Integer totalNum, boolean state) {
        projectDao.alterProject2(projectId,name,address,area,totalNum,state);
    }

}
