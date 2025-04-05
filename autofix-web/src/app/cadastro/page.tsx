import Cabecalho from '@/components/Cabecalho'
import React from 'react'

export default function page() {
  return (
    <>
        <Cabecalho ativo="cadastrar"/>
        <main className='flex justify-center'>
            <div className='bg-gray-400 p-6 m-6 rounded min-w-1/3'>
                <h2>Cadastrar</h2>
            </div>
        </main>
    </>
  )
}
