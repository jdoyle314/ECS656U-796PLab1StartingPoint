package client;

import com.grpc.matrixmult.MatrixRequest;
import com.grpc.matrixmult.MatrixReply;
import com.grpc.matrixmult.MatrixServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
          .usePlaintext()
          .build();

        MatrixServiceGrpc.MatrixServiceBlockingStub stub 
          = MatrixServiceGrpc.newBlockingStub(channel);

	int A[][] = { {1, 2, 3, 4}, 
                {5, 6, 7, 8}, 
                {9, 10, 11, 12},
                {13, 14, 15, 16}}; 

	int B[][] = { {1, 2, 3, 4}, 
          {5, 6, 7, 8}, 
          {9, 10, 11, 12},
          {13, 14, 15, 16}};
	MatrixReply A3M1=stub.multiplyBlock(MatrixRequest.newBuilder()//First Result Block Calculation
          .setA00(A[0][0])
          .setA01(A[0][1])
          .setA10(A[1][0])
          .setA11(A[1][1])
          .setB00(B[0][0])
          .setB01(B[0][1])
          .setB10(B[1][0])
          .setB11(B[1][1])
          .build());
	MatrixReply A3M2=stub.multiplyBlock(MatrixRequest.newBuilder()
          .setA00(A[0][2])
          .setA01(A[0][3])
          .setA10(A[1][2])
          .setA11(A[1][3])
          .setB00(B[2][0])
          .setB01(B[2][1])
          .setB10(B[3][0])
          .setB11(B[3][1])
          .build());
	MatrixReply A3=stub.addBlock(MatrixRequest.newBuilder()
          .setA00(A3M1.getC00())
          .setA01(A3M1.getC01())
          .setA10(A3M1.getC10())
          .setA11(A3M1.getC11())
          .setB00(A3M2.getC00())
          .setB01(A3M2.getC01())
          .setB10(A3M2.getC10())
          .setB11(A3M2.getC11())
          .build());
	MatrixReply B3M1=stub.multiplyBlock(MatrixRequest.newBuilder()//Second Result Block Calculation
          .setA00(A[0][0])
          .setA01(A[0][1])
          .setA10(A[1][0])
          .setA11(A[1][1])
          .setB00(B[0][2])
          .setB01(B[0][3])
          .setB10(B[1][2])
          .setB11(B[1][3])
          .build());
        MatrixReply B3M2=stub.multiplyBlock(MatrixRequest.newBuilder()
          .setA00(A[0][2])
          .setA01(A[0][3])
          .setA10(A[1][2])
          .setA11(A[1][3])
          .setB00(B[2][2])
          .setB01(B[2][3])
          .setB10(B[3][2])
          .setB11(B[3][3])
          .build());
        MatrixReply B3=stub.addBlock(MatrixRequest.newBuilder()
          .setA00(B3M1.getC00())
          .setA01(B3M1.getC01())
          .setA10(B3M1.getC10())
          .setA11(B3M1.getC11())
          .setB00(B3M2.getC00())
          .setB01(B3M2.getC01())
          .setB10(B3M2.getC10())
          .setB11(B3M2.getC11())
          .build());
	MatrixReply C3M1=stub.multiplyBlock(MatrixRequest.newBuilder()//Third Result Block Calculation
          .setA00(A[2][0])
          .setA01(A[2][1])
          .setA10(A[3][0])
          .setA11(A[3][1])
          .setB00(B[0][0])
          .setB01(B[0][1])
          .setB10(B[1][0])
          .setB11(B[1][1])
          .build());
        MatrixReply C3M2=stub.multiplyBlock(MatrixRequest.newBuilder()
          .setA00(A[2][2])
          .setA01(A[2][3])
          .setA10(A[3][2])
          .setA11(A[3][3])
          .setB00(B[2][0])
          .setB01(B[2][1])
          .setB10(B[3][0])
          .setB11(B[3][1])
          .build());
        MatrixReply C3=stub.addBlock(MatrixRequest.newBuilder()
          .setA00(C3M1.getC00())
          .setA01(C3M1.getC01())
          .setA10(C3M1.getC10())
          .setA11(C3M1.getC11())
          .setB00(C3M2.getC00())
          .setB01(C3M2.getC01())
          .setB10(C3M2.getC10())
          .setB11(C3M2.getC11())
          .build());
	MatrixReply D3M1=stub.multiplyBlock(MatrixRequest.newBuilder()//Fourth Result Block Calculation
          .setA00(A[2][0])
          .setA01(A[2][1])
          .setA10(A[3][0])
          .setA11(A[3][1])
          .setB00(B[0][2])
          .setB01(B[0][3])
          .setB10(B[1][2])
          .setB11(B[1][3])
          .build());
        MatrixReply D3M2=stub.multiplyBlock(MatrixRequest.newBuilder()
          .setA00(A[2][2])
          .setA01(A[2][3])
          .setA10(A[3][2])
          .setA11(A[3][3])
          .setB00(B[2][2])
          .setB01(B[2][3])
          .setB10(B[3][2])
          .setB11(B[3][3])
          .build());
        MatrixReply D3=stub.addBlock(MatrixRequest.newBuilder()
          .setA00(D3M1.getC00())
          .setA01(D3M1.getC01())
          .setA10(D3M1.getC10())
          .setA11(D3M1.getC11())
          .setB00(D3M2.getC00())
          .setB01(D3M2.getC01())
          .setB10(D3M2.getC10())
          .setB11(D3M2.getC11())
          .build());
	System.out.println("Final Answer");
	System.out.println(A3.getC00()+" "+A3.getC01()+" "+B3.getC00()+" "+B3.getC01());
	System.out.println(A3.getC10()+" "+A3.getC11()+" "+B3.getC10()+" "+B3.getC11());
	System.out.println(C3.getC00()+" "+C3.getC01()+" "+D3.getC00()+" "+D3.getC01());
	System.out.println(C3.getC10()+" "+C3.getC11()+" "+D3.getC10()+" "+D3.getC11());
        channel.shutdown();
    }
}
