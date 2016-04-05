using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ElectSmart.Startup))]
namespace ElectSmart
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
