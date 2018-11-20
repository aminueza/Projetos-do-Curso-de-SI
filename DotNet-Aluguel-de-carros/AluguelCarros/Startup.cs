using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(AluguelCarros.Startup))]
namespace AluguelCarros
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
