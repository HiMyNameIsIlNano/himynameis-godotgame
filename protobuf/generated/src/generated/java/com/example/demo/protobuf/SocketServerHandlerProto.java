// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: socketGrpcService.proto

package com.example.demo.protobuf;

public final class SocketServerHandlerProto {
  private SocketServerHandlerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027socketGrpcService.proto\032\014socket.proto\032" +
      "\033google/protobuf/empty.proto2\250\001\n\027SocketS" +
      "erverGrpcService\022F\n\017ConnectToServer\022\026.go" +
      "ogle.protobuf.Empty\032\031.SocketConnectionRe" +
      "sponse\"\000\022E\n\021CommunicatePeerId\022\026.SocketPe" +
      "erInfoMessage\032\026.google.protobuf.Empty\"\000B" +
      "5\n\031com.example.demo.protobufB\030SocketServ" +
      "erHandlerProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.example.demo.protobuf.SocketPush.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    com.example.demo.protobuf.SocketPush.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
