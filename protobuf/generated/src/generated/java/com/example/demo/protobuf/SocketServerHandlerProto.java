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
      "\033google/protobuf/empty.proto2a\n\027SocketSe" +
      "rverGrpcService\022F\n\017ConnectToServer\022\026.goo" +
      "gle.protobuf.Empty\032\031.SocketConnectionRes" +
      "ponse\"\000B5\n\031com.example.demo.protobufB\030So" +
      "cketServerHandlerProtob\006proto3"
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