import Cabecalho from '@/components/Cabecalho'
import React from 'react'

export default function page() {
  return (
    <>
        <Cabecalho ativo="ordem-servico"/>
        <main className='flex justify-center'>
            <div className='bg-gray-400 p-6 m-6 rounded min-w-1/3'>
                <h2>Ordem de Serviço</h2>
            </div>
        </main>
    </>
  )
}
