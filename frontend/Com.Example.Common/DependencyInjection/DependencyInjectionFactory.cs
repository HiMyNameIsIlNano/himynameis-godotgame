using System.Reflection;
using Autofac;

namespace Com.Example.Common.DependencyInjection
{
    public static class DependencyInjectionFactory
    {
        public static IContainer Container { get; private set; }

        public static void Build()
        {
            ContainerBuilder builder = new ContainerBuilder();

            builder.RegisterAssemblyTypes(Assembly.GetExecutingAssembly())
                .AsImplementedInterfaces()
                .Where(clazz => clazz.Name.EndsWith("Service"))
                .SingleInstance();

            Container = builder.Build();
        }
    }
}