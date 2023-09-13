import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Michael Rice
 * - workspace class, attributes are - String workspaceName, String workspaceDescription, UserAccount owner, List<UserAccount>
 */
public class Workspace {
	
	private String workspaceName;
	private String workspaceDescription;
	UserAccount owner;
	List<UserAccount> collaborators = new ArrayList<>();

	
	/**
	 * - workspace constructor
	 * @param workspaceName - name of a workspace
	 * @param workspaceDescription - description of a workspace
	 */
	public Workspace(String workspaceName,String workspaceDescription)
	{
		this.workspaceName = workspaceName;
		this.workspaceDescription = workspaceDescription;
	}
	
	
	/**
	 *  - method to add a collaborator to an instance of a workspace
	 * @param ua
	 */
	public void addCollaborator(UserAccount ua)
	{
		this.collaborators.add(ua);
	}
	
	
	@Override
	/**
	 * @return Formatted String - string representation of a given workspace Object
	 */
	public String toString()
	{
		return String.format("\n Workspace Name : %s \n Collaborators: %s  \n Description : %s", workspaceName,collaborators.toString(),workspaceDescription);
		
	}
	
	/**
	 * @return String - gets the WorkspaceName of a given workspace instance
	 */
	public String getWorkspaceName() {
		return workspaceName;
	}
	
	/**
	 * @param workspaceName - sets the name of a given workspace instance
	 */
	public void setWorkspaceName(String workspaceName) {
		this.workspaceName = workspaceName;
	}
	
	/**
	 * @return String - gets the workspaceDescription of a given workspace instance
	 */
	public String getWorkspaceDescription() {
		return workspaceDescription;
	}
	
	/**
	 * 
	 * @param workspaceDescription - sets the workspaceDescription of a given workspace instance
	 */
	public void setWorkspaceDescription(String workspaceDescription) {
		this.workspaceDescription = workspaceDescription;
	}
	
	

}
