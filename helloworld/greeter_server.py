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
"""The Python implementation of the GRPC helloworld.Greeter server."""

from concurrent import futures
import logging

import grpc
import helloworld_pb2
import helloworld_pb2_grpc
import math


class Greeter(helloworld_pb2_grpc.GreeterServicer):
    posCentro=500
    puntajes = {}

    def SayHello(self, request, context):
        return helloworld_pb2.HelloReply(message="Hello, %s!" % request.name)
    
    def SayHelloAgain(self, request, context):
        return helloworld_pb2.HelloReply(message= f"Hello again, {request.name}!" )
    
    def siguienteFecha(self, request, context):
        day=request.dia
        month=request.mes
        year=request.year
        if month==1 or month==3 or month==5 or month==7 or month==8 or month==10 or month==12:
            if day<31:
                day,month,year= self.suma(day,month,year)
            elif day== 31 and month==12:
                year=request.year+1
                month=1
                day=1
            elif day==31:
                month=request.mes+1
                day=1
        elif month==2:
            if day<28:
                day,month,year= self.suma(day,month,year)
            else:
                month=request.mes+1
                day=1
        else:
            if day<30:
                day,month,year= self.suma(day,month,year)
            else:
                month=request.mes+1
                day=1
        return helloworld_pb2.Fecha(dia=day,mes=month,year=year)
    
    def sumaDiasFecha(self, request, context):
        day=request.dia
        month=request.mes
        year=request.year
        for i in range(request.num_dias):
            if month==1 or month==3 or month==5 or month==7 or month==8 or month==10 or month==12:
                day,month,year= self.suma(day,month,year)
                if day== 31 and month==12:
                    year=request.year+1
                    month=1
                    day=0
                elif day==31:
                    month=request.mes+1
                    day=0
            elif month==2:
                day,month,year= self.suma(day,month,year)
                if day==28:
                    month=request.mes+1
                    day=0
            else:
                day,month,year= self.suma(day,month,year)
                if day==30:
                    month=request.mes+1
                    day=0
            #day,month,year1=self.siguienteFecha(helloworld_pb2.Fecha(request.dia,request.mes,request.year))
        return helloworld_pb2.Fecha(dia=day,mes=month,year=year)
    
    def suma(self, dia, mes, year):
        dia+=1
        return dia,mes,year 

    def dimeCentroDiana(self, request, context):
        return helloworld_pb2.Centro(distancia=self.posCentro)
    
    def disparaCannon(self,request,context):
        g=9.81
        d=request.velocidad*request.velocidad*math.sin(2*request.angulo)/g
        posBala=self.posCentro-d
        if request.nombre not in self.puntajes:
            self.puntajes[request.nombre]=posBala
        elif abs(self.puntajes[request.nombre])>abs(posBala):
            self.puntajes[request.nombre]=posBala
        return helloworld_pb2.Tiro(distancia=posBala)
    
    def mejorDisparo(self,request,context):
        lider=""
        menor_puntaje=100000
        for user,puntaje in self.puntajes.items():
            dist=abs(puntaje)
            if dist < menor_puntaje:
                menor_puntaje=dist
                lider=user
        mejor_puntaje=self.puntajes[lider]
        self.puntajes = {}
        return helloworld_pb2.Mejor(nombre=lider,distancia=mejor_puntaje)

def serve():
    port = "50051"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    helloworld_pb2_grpc.add_GreeterServicer_to_server(Greeter(), server)
    server.add_insecure_port("[::]:" + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()


if __name__ == "__main__":
    logging.basicConfig()
    serve()
