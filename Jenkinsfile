pipeline {
    agent {
        // Nos aseguramos de  'windows'
        label 'WinAgent-1'
    }

    parameters {
        choice(
            name: 'FEATURE_TO_RUN',
            choices: ['openweb.feature',
                      'All'],
            description: 'Selecciona el feature a ejecutar'
        )
    }

    stages {
        stage('Execution Test') {
            steps {
                script {
                    // Construir el comando para ejecutar pruebas basado en el parámetro
                    def command = './gradlew clean test'
                    if (params.FEATURE_TO_RUN != 'All') {
                        command += " -Dcucumber.features=src/test/resources/features/${params.FEATURE_TO_RUN}"
                    }
                    // Ejecutar el comando
                    echo "Running command: ${command}"
                    bat command
                }
            }
            post {
                always {
                    script {
                        echo "Moving report after test execution."
                        // Ejecutar el paso de mover el reporte aquí mismo después de la ejecución de pruebas
                        //sleep time: 60, unit: "SECONDS"
                        bat """
                            @echo off
                            setlocal enabledelayedexpansion

                            REM Obtener la fecha y hora actual para crear el nombre de la carpeta
                            for /f "tokens=1-4 delims=/ " %%a in ("%date%") do (
                                set "day=%%a"
                                set "month=%%b"
                                set "year=%%c"
                            )
                            for /f "tokens=1-3 delims=: " %%a in ("%time%") do (
                                set "hour=%%a"
                                set "minute=%%b"
                                set "second=%%c"
                            )

                            REM Crear la carpeta con el formato de fecha y hora
                            set "timestamp=%year%-%month%-%day%_%hour%-%minute%-%second%"
                            set "destination=C:\\Users\\rodri\\Documents\\Reports\\serenity\\%timestamp%"
                            md "%destination%" 2>nul

                            REM Copiar la carpeta "serenity" al destino
                            set "source=C:\\Jenkins\\workspace\\PipEjecutionProyect\\target\\site\\serenity"
                            xcopy /E /I /Y "%source%" "%destination%"

                            echo Copia completada. Los archivos han sido copiados a "%destination%"
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                echo "Pipeline execution finished."
            }
        }
        failure {
            script {
                echo "Pipeline execution failed."
            }
        }
    }
}