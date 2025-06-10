# Copyright 2015 gRPC authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
"""The Python implementation of the GRPC helloworld.Greeter client."""

from __future__ import print_function

import logging

import grpc
import helloworld_pb2
import helloworld_pb2_grpc
import random


def run():
    # NOTE(gRPC Python Team): .close() is possible on a channel and should be
    # used in circumstances in which the with statement does not fit the needs
    # of the code.
    usuarios=["Ivonne","Mia","Victoria"]
    distancia_tiro=10
    N_dias=5


    print("Will try to greet world ...")
    with grpc.insecure_channel("localhost:50051") as channel:
        stub = helloworld_pb2_grpc.GreeterStub(channel)
        response = stub.SayHello(helloworld_pb2.HelloRequest(name="you"))
        print("Greeter client received: " + response.message)
        response= stub.SayHelloAgain(helloworld_pb2.HelloRequest(name="you"))
        print("Greeter client received: " + response.message)
        response= stub.siguienteFecha(helloworld_pb2.Fecha(dia=31,mes=12,year=25))
        print(f"Fecha más un dia es: {response.dia}/{response.mes}/{response.year}")
        response= stub.sumaDiasFecha(helloworld_pb2.SumaFecha(dia=26,mes=2,year=25,num_dias=N_dias))
        print(f"Fecha más {N_dias} días es: {response.dia}/{response.mes}/{response.year}")

        response= stub.dimeCentroDiana(helloworld_pb2.Vacio())
        print(f"Centro de la diana: {response.distancia} metros")

        for user in usuarios:
            while abs(distancia_tiro)>=1:
                response= stub.disparaCannon(helloworld_pb2.Disparo(nombre=user,angulo=random.uniform(0,1.5708),velocidad=random.uniform(50,100)))
                distancia_tiro=response.distancia
            distancia_tiro=10
            print(f"El usuario {user} acertó, cuyo tiro se encuentra a {response.distancia} metros del centro de la diana")
        
        response= stub.mejorDisparo(helloworld_pb2.Vacio())
        print(f"El mejor tirador es: {response.nombre} cuyo disparo quedó a: {response.distancia} m del centro")

if __name__ == "__main__":
    logging.basicConfig()
    run()
