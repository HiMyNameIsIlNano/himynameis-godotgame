using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Reflection;
using Autofac;
using Com.Example.Common.DependencyInjection;
using Com.Example.Game.Scripts.GameStartup;

namespace Com.Example.Common.Attributes
{
    public static class InjectedPropertyResolver
    {
        public static void Resolve(object obj)
        {
            IContainer container = DependencyInjectionFactory.Container;
            Debug.Assert(container != null, "Container IS null");

            List<PropertyInfo> propertiesToInject = obj.GetType()
                .GetProperties(BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Instance)
                .Where(x => x.GetCustomAttributes(typeof(InjectedPropertyAttribute), false).Any())
                .ToList();

            foreach (var property in propertiesToInject)
            {
                var objectToInject = container.Resolve(property.PropertyType);
                property.SetValue(obj, objectToInject, null);
            }
        }
    }
}