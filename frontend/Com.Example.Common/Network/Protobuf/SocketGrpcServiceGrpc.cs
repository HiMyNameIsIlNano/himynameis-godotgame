// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: socketGrpcService.proto
// </auto-generated>
#pragma warning disable 0414, 1591
#region Designer generated code

using grpc = global::Grpc.Core;

public static partial class SocketServerGrpcService
{
  static readonly string __ServiceName = "SocketServerGrpcService";

  static readonly grpc::Marshaller<global::Google.Protobuf.WellKnownTypes.Empty> __Marshaller_google_protobuf_Empty = grpc::Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Google.Protobuf.WellKnownTypes.Empty.Parser.ParseFrom);
  static readonly grpc::Marshaller<global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse> __Marshaller_SocketConnectionResponse = grpc::Marshallers.Create((arg) => global::Google.Protobuf.MessageExtensions.ToByteArray(arg), global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse.Parser.ParseFrom);

  static readonly grpc::Method<global::Google.Protobuf.WellKnownTypes.Empty, global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse> __Method_ConnectToServer = new grpc::Method<global::Google.Protobuf.WellKnownTypes.Empty, global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "ConnectToServer",
      __Marshaller_google_protobuf_Empty,
      __Marshaller_SocketConnectionResponse);

  /// <summary>Service descriptor</summary>
  public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
  {
    get { return global::SocketGrpcServiceReflection.Descriptor.Services[0]; }
  }

  /// <summary>Base class for server-side implementations of SocketServerGrpcService</summary>
  [grpc::BindServiceMethod(typeof(SocketServerGrpcService), "BindService")]
  public abstract partial class SocketServerGrpcServiceBase
  {
    public virtual global::System.Threading.Tasks.Task<global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse> ConnectToServer(global::Google.Protobuf.WellKnownTypes.Empty request, grpc::ServerCallContext context)
    {
      throw new grpc::RpcException(new grpc::Status(grpc::StatusCode.Unimplemented, ""));
    }

  }

  /// <summary>Client for SocketServerGrpcService</summary>
  public partial class SocketServerGrpcServiceClient : grpc::ClientBase<SocketServerGrpcServiceClient>
  {
    /// <summary>Creates a new client for SocketServerGrpcService</summary>
    /// <param name="channel">The channel to use to make remote calls.</param>
    public SocketServerGrpcServiceClient(grpc::ChannelBase channel) : base(channel)
    {
    }
    /// <summary>Creates a new client for SocketServerGrpcService that uses a custom <c>CallInvoker</c>.</summary>
    /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
    public SocketServerGrpcServiceClient(grpc::CallInvoker callInvoker) : base(callInvoker)
    {
    }
    /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
    protected SocketServerGrpcServiceClient() : base()
    {
    }
    /// <summary>Protected constructor to allow creation of configured clients.</summary>
    /// <param name="configuration">The client configuration.</param>
    protected SocketServerGrpcServiceClient(ClientBaseConfiguration configuration) : base(configuration)
    {
    }

    public virtual global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse ConnectToServer(global::Google.Protobuf.WellKnownTypes.Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return ConnectToServer(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    public virtual global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse ConnectToServer(global::Google.Protobuf.WellKnownTypes.Empty request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_ConnectToServer, null, options, request);
    }
    public virtual grpc::AsyncUnaryCall<global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse> ConnectToServerAsync(global::Google.Protobuf.WellKnownTypes.Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return ConnectToServerAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    public virtual grpc::AsyncUnaryCall<global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse> ConnectToServerAsync(global::Google.Protobuf.WellKnownTypes.Empty request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_ConnectToServer, null, options, request);
    }
    /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
    protected override SocketServerGrpcServiceClient NewInstance(ClientBaseConfiguration configuration)
    {
      return new SocketServerGrpcServiceClient(configuration);
    }
  }

  /// <summary>Creates service definition that can be registered with a server</summary>
  /// <param name="serviceImpl">An object implementing the server-side handling logic.</param>
  public static grpc::ServerServiceDefinition BindService(SocketServerGrpcServiceBase serviceImpl)
  {
    return grpc::ServerServiceDefinition.CreateBuilder()
        .AddMethod(__Method_ConnectToServer, serviceImpl.ConnectToServer).Build();
  }

  /// <summary>Register service method with a service binder with or without implementation. Useful when customizing the  service binding logic.
  /// Note: this method is part of an experimental API that can change or be removed without any prior notice.</summary>
  /// <param name="serviceBinder">Service methods will be bound by calling <c>AddMethod</c> on this object.</param>
  /// <param name="serviceImpl">An object implementing the server-side handling logic.</param>
  public static void BindService(grpc::ServiceBinderBase serviceBinder, SocketServerGrpcServiceBase serviceImpl)
  {
    serviceBinder.AddMethod(__Method_ConnectToServer, serviceImpl == null ? null : new grpc::UnaryServerMethod<global::Google.Protobuf.WellKnownTypes.Empty, global::Com.Example.Demo.Protobuf.Socket.SocketConnectionResponse>(serviceImpl.ConnectToServer));
  }

}
#endregion