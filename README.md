Ejercicio 7: Cola de Impresión Centralizada

Contexto del problema: Una oficina comparte una impresora de red de alto volumen. Múltiples terminales de usuario envían documentos a imprimir de manera concurrente. El sistema operativo de la central de impresión debe procesar los trabajos en orden estricto de llegada sin perder documentos ni duplicar tareas.

Objetivo de aprendizaje: Implementar un Singleton que coordine una estructura de datos tipo cola bajo un entorno de múltiples peticiones concurrentes.

Requisitos funcionales:

Permitir encolar nuevos documentos con metadatos asociados (nombre del archivo y autor).

Procesar secuencialmente los documentos de la cola simulando la impresión física y eliminándolos conforme se completan.

Restricciones técnicas:

La estructura de la cola y los métodos de encolado y desencolado deben residir exclusivamente dentro de la instancia Singleton.

La implementación debe contemplar mecanismos de seguridad ante concurrencia para evitar condiciones de carrera al manipular la estructura de datos.

# Ejercicio 7: Fila de Transferencias Pendientes (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Procesamiento ordenado en cola de transferencias entrantes.

## Consigna

El banco recibe transferencias desde distintos canales al mismo tiempo (App celular, página web, cajas) y necesita procesarlas en orden de llegada sin perder operaciones ni mezclar el turno de cada cliente. Si cada canal manejara su propia fila por separado, se perdería el orden general de atención del sistema.

El objetivo es aplicar el patrón Singleton para centralizar la cola de transferencias pendientes en una única fila compartida, permitiendo agregar operaciones y procesarlas en orden de llegada (`FIFO`) desde cualquier canal.

## Explicación lógica

1. Atributos: En la clase FilaTransferenciasPendientes se declara filaTransferencias (private Queue) implementada con LinkedList para mantener las transferencias en orden de llegada, y instancia (private static FilaTransferenciasPendientes), que va a conservar la única referencia en memoria para que todos los canales agreguen y atiendan sobre la misma cola.


2. Instancia única: El constructor se define como private para impedir que se creen filas independientes usando new, y además inicializa filaTransferencias vacía cuando se crea por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.


3. Asignación y Acceso: En Main, se obtiene la instancia desde dos canales (filaAppCelular y filaPaginaWeb) y se cargan transferencias con agregarALaFila(...), que las suma al final de la cola e informa cuántas quedan en espera. Luego, al invocar procesarSiguiente(), se extrae y atiende primero la más antigua con poll() (o se avisa si no hay pendientes), y la comparación filaAppCelular == filaPaginaWeb confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* FilaTransferenciasPendientes.java: Implementa el Singleton con la cola encapsulada y los métodos agregarALaFila(...) y procesarSiguiente()
* Main.java: Encola transferencias desde distintos canales, las procesa en orden de llegada y verifica que comparten la misma instancia

