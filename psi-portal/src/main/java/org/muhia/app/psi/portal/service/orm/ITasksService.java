/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.TasksList;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface ITasksService {

    Optional<Collection<TasksList>> findTaskListByStatus(int status);

}
