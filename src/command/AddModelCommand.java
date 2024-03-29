package command;/**
 * @author mewCu
 * @description
 * @date 2019/9/24 19:00
 * @modified
 */

import middleware.DataContainer;

/**
 *@ClassName AddModelCommand
 *@Description 添加命令
 *@Author mewCu
 *Date 2019/9/24 19:00
 */
public class AddModelCommand extends BaseMindCommand {

    private String model="";

    @Override
    public String toString() {
        return "";
    }


    @Override
    public void execute() {
        getDc().add(getModel());
    }

    @Override
    public void undo() {
        getDc().delete(getModel());
    }

    public AddModelCommand(String model, DataContainer dc) {
        super(dc);
        this.model=model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
