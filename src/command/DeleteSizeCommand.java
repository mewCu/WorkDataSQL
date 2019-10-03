package command;
import middleware.*;
import modle.*;

public class DeleteSizeCommand extends BaseMindCommand
{

	private String model="";
    private String procedure="";
    private String color="";
	private String size="";

public void setModel(String model)
{
this.model = model;
}

public String getModel()
{
return model;
}

public void setProcedure(String procedure)
{
this.procedure = procedure;
}


public String getProcedure()
{              
return procedure ; 
}              
              
public void setColor(String color)
{
this.color = color;
}

public String getColor()
{
return color;
}

public void setSize(String size)
{
this.size = size;
}

public String getSize()
{
return size;
}
	
	@Override
	public void execute()
	{
		// TODO: Implement this method
		Procedure pd=getDc().delete(getModel(),getProcedure(),getColor(),getSize());
		if(pd!=null){
			setCanUndo(true);
		}
	}

	@Override
	public void undo()
	{
		// TODO: Implement this method
		if(!isCanUndo()){
			return;
		}
		getDc().add(getModel(),getProcedure(),getColor(),getSize());
		setCanUndo(false);
	}
	
	
	public DeleteSizeCommand(String model,String procedure,String color,String size,DataContainer dc){
		super(dc);
		this.model=model;
		this.procedure=procedure;
		this.color=color;
		this.size=size;
	}
	
}
