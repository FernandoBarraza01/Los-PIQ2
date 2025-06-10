from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class HelloRequest(_message.Message):
    __slots__ = ("name",)
    NAME_FIELD_NUMBER: _ClassVar[int]
    name: str
    def __init__(self, name: _Optional[str] = ...) -> None: ...

class HelloReply(_message.Message):
    __slots__ = ("message",)
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    message: str
    def __init__(self, message: _Optional[str] = ...) -> None: ...

class Fecha(_message.Message):
    __slots__ = ("dia", "mes", "year")
    DIA_FIELD_NUMBER: _ClassVar[int]
    MES_FIELD_NUMBER: _ClassVar[int]
    YEAR_FIELD_NUMBER: _ClassVar[int]
    dia: int
    mes: int
    year: int
    def __init__(self, dia: _Optional[int] = ..., mes: _Optional[int] = ..., year: _Optional[int] = ...) -> None: ...

class SumaFecha(_message.Message):
    __slots__ = ("dia", "mes", "year", "num_dias")
    DIA_FIELD_NUMBER: _ClassVar[int]
    MES_FIELD_NUMBER: _ClassVar[int]
    YEAR_FIELD_NUMBER: _ClassVar[int]
    NUM_DIAS_FIELD_NUMBER: _ClassVar[int]
    dia: int
    mes: int
    year: int
    num_dias: int
    def __init__(self, dia: _Optional[int] = ..., mes: _Optional[int] = ..., year: _Optional[int] = ..., num_dias: _Optional[int] = ...) -> None: ...

class Centro(_message.Message):
    __slots__ = ("distancia",)
    DISTANCIA_FIELD_NUMBER: _ClassVar[int]
    distancia: float
    def __init__(self, distancia: _Optional[float] = ...) -> None: ...

class Disparo(_message.Message):
    __slots__ = ("nombre", "angulo", "velocidad")
    NOMBRE_FIELD_NUMBER: _ClassVar[int]
    ANGULO_FIELD_NUMBER: _ClassVar[int]
    VELOCIDAD_FIELD_NUMBER: _ClassVar[int]
    nombre: str
    angulo: float
    velocidad: float
    def __init__(self, nombre: _Optional[str] = ..., angulo: _Optional[float] = ..., velocidad: _Optional[float] = ...) -> None: ...

class Tiro(_message.Message):
    __slots__ = ("distancia",)
    DISTANCIA_FIELD_NUMBER: _ClassVar[int]
    distancia: float
    def __init__(self, distancia: _Optional[float] = ...) -> None: ...

class Mejor(_message.Message):
    __slots__ = ("nombre", "distancia")
    NOMBRE_FIELD_NUMBER: _ClassVar[int]
    DISTANCIA_FIELD_NUMBER: _ClassVar[int]
    nombre: str
    distancia: float
    def __init__(self, nombre: _Optional[str] = ..., distancia: _Optional[float] = ...) -> None: ...

class Vacio(_message.Message):
    __slots__ = ()
    def __init__(self) -> None: ...
