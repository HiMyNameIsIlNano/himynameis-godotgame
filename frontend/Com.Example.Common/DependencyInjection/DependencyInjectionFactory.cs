using Autofac;
using Com.Example.Common.Services.AnotherTest;
using Com.Example.Common.Services.BaseService;
using Com.Example.Game.Scripts.Test;

namespace Com.Example.Common.DependencyInjection
{
    public static class DependencyInjectionFactory
    {
        private static IContainer Container { get; set; }

        // TODO: This is horrible and looks terribly wrong, but for the time being I will stick with that
        public static IContainer GetContainer()
        {
            return Container;
        }

        public static void Build()
        {
            ContainerBuilder builder = new ContainerBuilder();

            // TODO: this works so far, but I guess I need to register a Module or something similar to have all the services from the
            // ClassLibrary Com.Example.Common to be inject automatically
            builder.RegisterType<TestService>()
                .As<ITestService>()
                .SingleInstance();

            builder.RegisterType<AnotherTestService>()
                .As<IAnotherTestService>()
                .SingleInstance();

            builder.RegisterType<BaseService>()
                .As<IBaseService>()
                .SingleInstance();

            builder.RegisterType<ConcreteService>()
                .As<IConcreteService>()
                .SingleInstance();

            Container = builder.Build();
        }
    }
}