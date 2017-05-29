package velocityconfig;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.config.ConfigurationUtils;
import org.apache.velocity.tools.config.FactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.apache.velocity.tools.view.ViewToolManager;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

public class VelocityToolsView extends VelocityToolboxView
{
	static ViewToolManager toolManager = null ;

	@Override
	protected Context createVelocityContext(
			Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		if( toolManager == null)
		{
			// autoConfigをtrueにするとバグと思われる現象が発生するためfalseに設定する
			toolManager
			= new ViewToolManager(getServletContext(), false, true);
			toolManager.setVelocityEngine(getVelocityEngine());

			toolManager.configure(getFactoryConfiguration());
		}
		//

		ViewToolContext viewToolContext = toolManager.createContext(request, response);
		viewToolContext.putAll(model);

		return viewToolContext;
	}


	private FactoryConfiguration getFactoryConfiguration()
	{
		String[] pathes = getToolboxConfigLocation().split( "," );
		FactoryConfiguration toolboxConfiguration = new FactoryConfiguration();
		for (String path : pathes)
		{
			String trimedPath = path.trim(); // 改行、スペースを削除
			FactoryConfiguration configuration = ConfigurationUtils.find( trimedPath );
			if (configuration == null)
			{
				throw new RuntimeException("VelocityTools configuration not found :" + trimedPath);
			}
			toolboxConfiguration.addConfiguration( configuration );
		}

		return toolboxConfiguration;
	}

}

