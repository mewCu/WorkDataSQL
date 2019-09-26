package command;/**
 * @author mewCu
 * @description
 * @date 2019/9/25 21:09
 * @modified
 */

import middleware.DataContainer;
import modle.WorkData;

/**
 *@ClassName AddProcedureCommand
 *@Description 添加工序
 *@Author mewCu
 *Date 2019/9/25 21:09
 */
public class AddProcedureCommand extends MindCommand {

    private String model="";
    private String procedure="";
    private String color="";

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void execute() {
        getDc().add(getModel(), getProcedure(), getColor());
    }

    @Override
    public void undo() {
        getDc().delete(getModel(), getProcedure(), getColor());
    }

    public AddProcedureCommand(String model,String procedure,String color,DataContainer dc) {
        super(dc);
        this.model=model;
        this.procedure=procedure;
        this.color=color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
